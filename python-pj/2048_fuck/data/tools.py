__author__ = 'justinarmstrong'

import os, random
import curses

stdscr = curses.initscr()
curses.noecho()
curses.cbreak()
curses.start_color()
curses.use_default_colors()
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
        self.game_data = {}
        self.event = 'Restart'

    def setup_states(self, state_dict, start_state):
        self.state_dict = state_dict
        self.state_name = start_state
        self.state = self.state_dict[self.state_name]

    def update(self):
        self.state.update(self.screen, self.event)

        if self.state.quit: # 如果state给出退出信号
            self.done = True
        elif self.state.done: # 如果state结束
            self.flip_state()

    def flip_state(self):
        previous, self.state_name = self.state_name, self.state.next
        persist = self.state.cleanup()

        self.state = self.state_dict[self.state_name] # 转换状态
        self.state.previous = previous
        self.state.startup(persist)


    def event_loop(self):
        if self.event == 'Exit':
            self.done = True
        else:
            self.event = get_user_action(stdscr)
            self.state.get_event(self.event)

    def main(self):
        """Main loop for entire program"""

        while not self.done:
            self.event_loop()
            self.update()
        curses.endwin()


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


    data_dict = {'highscore': 0,
                 'score': 0,
                 'isWin': False,
                 'isLose':False,
                 'win_score':32,
                 'width': 4,
                 'height': 4
    }

    return data_dict







