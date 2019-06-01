import socket

sock = socket.socket()
sock.bind(('', 14900))
sock.listen(10)
conn, addr = sock.accept()

print ('connected:', addr)

data = conn.recv(1024)
if not data:
    print("Ничего не пришло")
    conn.close()
    
udata = data.decode("utf-8")
udata = udata.split(" ")
str_data = ""
for i in range(0, len(udata)):
    udata[i] = int(udata[i])
detMatr = (udata[0] + udata[3]) - (udata[1] + udata[2])
for j in range(0, len(udata)):
    udata[j] = udata[j]* detMatr
for i in range(0, len(udata)):
    str_data = str_data + str(udata[i]) + " "

    
conn.send(str_data.encode("utf-8"))
conn.close()
