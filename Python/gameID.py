

def run(data):
    maxDifference = 0
    userSessions = dict()

    for session in data:
        session = session.split(',')
        try:
            if session[2] == userSessions[session[1]][1] and session[1] in userSessions:
                if session[3] == 'quit' and userSessions[session[1]][2] == 'join':
                    difference = int(session[0]) - int(userSessions[session[1]][0])
                    if maxDifference < difference:
                        maxDifference = difference
        except:
            userSessions[session[1]] = (session[0],session[2],session[3])
    
    return maxDifference

def main():
    data = [
        "1000000,user1,1001,join",
        "1000005,user2,1002,join",
        "1000010,user1,1001,quit",
        "1000020,user2,1002,quit",
    ]
    print(run(data))


if __name__ == '__main__':
    main()
