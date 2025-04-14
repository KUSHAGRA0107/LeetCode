class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        hand.sort()
        hashMap = defaultdict(int)
        for i in range(len(hand)):
            hashMap[hand[i]] += 1
        for i in range(len(hand)):
            if hand[i] in hashMap:
                element = hand[i]
                hashMap[element] -= 1
                if hashMap[element] == 0:
                    del hashMap[element]
                counter = 1
                nextElement = element + 1
                while counter != groupSize and nextElement in hashMap:
                    hashMap[nextElement] -= 1
                    if hashMap[nextElement] == 0:
                        del hashMap[nextElement]
                    nextElement += 1
                    counter += 1
                if counter != groupSize:
                    return False
        return True

        