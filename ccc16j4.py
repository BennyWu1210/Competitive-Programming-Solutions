N = input()
h = int(N[0:2])
m = int(N[3:])

counter = 0
while counter < 6:
    if 7 <= h < 10 or 15 <= h < 19:
        m += 20
        if m >= 60:
            if h == 24:
                h = 0
                if m >= 60:
                    m = 0
                    h += 1
            else:
                m = 0
                h += 1
        if 7 <= h < 10 or 15 <= h < 19:
            m += 20
            if m >= 60:
                if h == 24:
                    h = 0
                    if m >= 60:
                        m = 0
                        h += 1
                else:
                    m = 0
                    h += 1
        else:
            m += 10
            if m >= 60:
                if h == 24:
                    h = 0
                    if m >= 60:
                        m = 0
                        h += 1
                else:
                    m = 0
                    h += 1

    else:
        m += 20
        if m >= 60:
            if m >= 60:
                if h == 24:
                    h = 0
                    if m >= 60:
                        m = 0
                        h += 1
                else:
                    m = 0
                    h += 1
            else:
                if m >= 60:
                    if h == 24:
                        h = 0
                        if m >= 60:
                            m = 0
                            h += 1
                    else:
                        m = 0
                        h += 1
                else:
                    m = 0
                    h += 1

    counter += 1

if h == 24:
    h = 0




if h >= 10:
    if m != 0:
        print(str(h) + ':' + str(m))
    else:
        print(str(h) + ':0' + str(m))
else:
    if m != 0:
        print('0'+str(h) + ':' + str(m))
    else:
        print('0'+str(h) + ':0' + str(m))






