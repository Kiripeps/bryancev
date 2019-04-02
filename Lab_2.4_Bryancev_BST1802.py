#Задание 4
userList = list(input("Введите элементы списка через пробел \n").split())
print(len(userList))
del userList[0:2]

newList = list(input("Введите новые элементы через пробел \n").split())
userList = userList + newList
print (userList)

