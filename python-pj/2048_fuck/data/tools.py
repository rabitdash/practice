__author__ = 'justinarmstrong'

import os, random
import curses

stdscr = curses.initscr()
curses.noecho()
curses.cbreak()
curses.
stdscr.keypad(1)
letter_codes = [ord(ch) for ch in 'WASDRQwasdrq']
actions = ['Up', 'Left', 'Down', 'Right', 'Restart', 'Exit']
actions_dict = dict(zip(letter_codes, actions * 2))

# 获取用户输入
def get_user_action(keyboard):
    char = 'N'
    while char not in actions_dict:
        char = keyboard.getch()
    return actions_dict[char]

class Control(object):
    """
    Control class for entire project.  Contains the game loop, and contains
    the event_loop which passes events to States as needed.  Logic for flipping
    states is also found here.
    """
    def __init__(self):
        self.screen = stdscr
        self.done = False
        self.state_dict = {}
        self.state_name = None
        self.state = None

    def setup_states(self, state_dict, start_state):
        self.state_dict = state_dict
        self.state_name = start_state
        self.state = self.state_dict[self.state_name]

    def update(self):
        if self.state.quit:
            self.done = True
        elif self.state.done:
            self.flip_state()
        self.state.update(self.screen, self.events)

    def flip_state(self):
        previous, self.state_name = self.state_name, self.state.next
        persist = self.state.cleanup()
        self.state = self.state_dict[self.state_name]
        self.state.previous = previous
        self.state.startup(persist)

    def event_loop(self):
        self.events = get_user_action(stdscr)

        for event in self.events:
            if event == 'Exit':
                self.done = True
            else:
                self.state.get_event(event)

    def main(self):
        """Main loop for entire program"""
        while not self.done:
            self.event_loop()
            self.update()


class _State(object):
    """Base class for all game states"""
    def __init__(self):
        self.done = False
        self.quit = False
        self.next = None
        self.previous = None
        self.game_data = {}

    def get_event(self, event):
        pass

    def startup(self, game_data):
        self.game_data = game_data

    def cleanup(self):
        self.done = False
        return self.game_data

    def update(self, screen, event):
        pass

def create_game_data_dict():
    """Create a dictionary of persistant values the player
    carries between states"""


    data_dict = {'Highscore': 0,
                 'Score': 0,
                 'Win': False,
                 'Lose':False,
                 'Winscore':32,
    }

    return data_dict







