import socket

conn = socket.socket()
conn.connect(('localhost', 14900))

one_str = input("Введите через пробел 2 элемента первой строки \n")
two_str = input("Введите через пробел 2 элемента второй строки \n")
one_str.split(" ")
two_str.split(" ")
matr = one_str + " " + two_str

conn.send(matr.encode("utf-8"))
data = b""
tmp = conn.recv(1024)
while tmp:
    data += tmp
    tmp = conn.recv(1024)
data = data.decode("utf-8")
data = data.split(" ")
print(data[0]+ " " + data[1])
print(data[2]+ " " + data[3])    
conn.close()
