import socket
import re

sock = socket.socket()
sock.bind(('', 8848))
sock.listen(1)
serv, addr = sock.accept()
while True:
    print('Waiting for connection...')
    data = serv.recv(34000)
    print('connection established')
    data = data.decode()
    data = re.findall(r'\d+', data)
    a = float(data[0])
    b = float(data[1])
    c = float(data[2])
    k = float(data[3])

    try:
        result = (abs((a**2/b**2 + (c**2)*(a**2))/ ( a + b + c*(k -a /(b**3))) + c +(k/b - k/a)*c))
        result = 'Answer = ' + str(result)
        serv.send(result.encode())
    except:
        result = "Sorry, but you cant devide by 0"
        serv.send(result.encode())
