import socket
sock = socket.socket()
sock.connect(('localhost', 8848))

s = []
a = input("Введите a - ")
b = input("Введите b - ")
c = input("Введите c - ")
k = input("Введите k - ")


s.append(a)
s.append(b)
s.append(c)
s.append(k)
s = str(s)
sock.send(s.encode())

result = sock.recv(34000)
result = result.decode()
sock.close()
print(result)
