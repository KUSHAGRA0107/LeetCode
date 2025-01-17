class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        radiantQueue = []
        direQueue = []
        size = len(senate)

        for i in range(size):
            if senate[i] == 'R':
                radiantQueue.append(i)
            else:
                direQueue.append(i)
        
        while radiantQueue and direQueue:
            r,q = radiantQueue.pop(0), direQueue.pop(0)

            if r < q:
                radiantQueue.append(r + size)
            else:
                direQueue.append(q + size)

        return "Dire" if len(direQueue) > 0 else "Radiant"