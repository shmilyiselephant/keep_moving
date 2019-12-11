import sys
sys.path.append('.')
from linked_stack import LinkedStack

class NewLinkedStack(LinkedStack):

    def is_empty(self):
        return not self.top

class Browser:

    def __init__(self):
        self.forward_stack = NewLinkedStack()
        self.backward_stack = NewLinkedStack()

    def can_forward(self):
        if self.backward_stack.is_empty():
            return False
        return True

    def can_back(self):
        if self.forward_stack.is_empty():
            return False
        return True

    def open(self, url):
        print("Open new url %s" % url, end="\n")
        self.forward_stack.push(url)

    def back(self):
        if self.forward_stack.is_empty():
            return

        top = self.forward_stack.pop()
        self.backward_stack.push(top)
        print("back to %s" % top, end="\n")

    def forward(self):
        if self.backward_stack.is_empty():
            return

        top = self.backward_stack.pop()
        self.forward_stack.push(top)
        print("forward to %s" % top, end="\n")

if __name__ == "__main__":
    browser = Browser()
    browser.open('a')
    browser.open('b')
    browser.open('c')
    if browser.can_back():
        browser.back()
        browser.back()

    if browser.can_forward():
        browser.forward()

    browser.back()
    browser.back()
    browser.back()
