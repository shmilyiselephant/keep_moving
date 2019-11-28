class TrieNode:
    def __init__(self, data="", isEndingChar=False):
        self.data = data
        self.children = [None] * 26
        self.isEndingChar = isEndingChar


class Trie:
    def __init__(self):
        self.root = TrieNode("/")

    def insert(self, text: str):
        p = self.root
        for i in text:
            index = ord(i) - ord('a')
            if not p.children[index]:
                new_node = TrieNode(i)
                p.children[index] = new_node
            p = p.children[index]
        p.isEndingChar = True

    def find(self, pattern: str):
        p = self.root
        for i in pattern:
            index = ord(i) - ord('a')
            if not p.children[index]:
                return False
            p = p.children[index]
        return p.isEndingChar


if __name__ == "__main__":
    new_trie = Trie()
    new_trie.insert("hello")
    new_trie.insert("world")
    print(new_trie.find("he"))
    print(new_trie.find("world"))
    new_trie.insert("hi")
    print(new_trie.find("hi"))
