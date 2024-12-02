class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        words = sentence.split()  # Split the sentence into words

        for idx, word in enumerate(words):
            if word.startswith(searchWord):  # Check if word starts with searchWord
                return idx + 1  # Return the 1-based index of the word
        
        return -1  # Return -1 if no word matches
