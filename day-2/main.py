# Rock: A
# Paper: B
# Scissors: C

moveScores = {'A': 1, 'B': 2, 'C': 3}

resScores = {'X': 0, 'Y': 3, 'Z': 6}

eqMoves = {'X': 'A', 'Y': 'B', 'Z': 'C'}

def getMyScore(op, me):
    myScore = 3 # draw (default)
    if op != eqMoves[me]:
        match me:
            case 'X':
                myScore = 6 if op == 'C' else 0
            case 'Y':
                myScore = 6 if op == 'A' else 0
            case 'Z':
                myScore = 6 if op == 'B' else 0
    
    return myScore + moveScores[eqMoves[me]]

def getMyScoreFromResult(op, res):
    myMove = op # draw (default)
    if res != 'Y':
        match op:
            case 'A':
                myMove = 'B' if res == 'Z' else 'C'
            case 'B':
                myMove = 'C' if res == 'Z' else 'A'
            case 'C':
                myMove = 'A' if res == 'Z' else 'B'
    
    return resScores[res] + moveScores[myMove]

def getMyTournamentScore(inputName):
    totalScore = 0
    with open(inputName) as f:
        for line in f:
            moves = line.split()
            totalScore += getMyScore(moves[0], moves[1])
    
    print("My tournament score is: {total}".format(total = totalScore))
    return totalScore

def getMyTournamentScorePart2(inputName):
    totalScore = 0
    with open(inputName) as f:
        for line in f:
            moves = line.split()
            totalScore += getMyScoreFromResult(moves[0], moves[1])
    
    print("My tournament score is: {total}".format(total = totalScore))
    return totalScore

def testPart1():
    expected = 15
    total = getMyTournamentScore('test_input.txt')
    print("Expected {exp}, got {total} - {test}".format(exp = expected, total = total, test = "Passed" if expected == total else "Failed"))

def testPart2():
    expected = 12
    total = getMyTournamentScorePart2('test_input.txt')
    print("Expected {exp}, got {total} - {test}".format(exp = expected, total = total, test = "Passed" if expected == total else "Failed"))
            

def main():
    # testPart1()
    # getMyTournamentScore('input.txt')
    # testPart2()
    getMyTournamentScorePart2('input.txt')


if __name__ == "__main__":
    main()