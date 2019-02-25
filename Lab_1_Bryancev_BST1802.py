import random
#Задание один
y = 0
a = int(input("Введите а ="))
b = int(input("Введите b ="))
c = int(input("Введите c ="))
k = int(input("Введите k ="))
if a == 0 or b == 0 or c == 0 or k == 0:
    print ("Ошибка, не один из аргументов не может равняться нулю")
else :   
    y = abs((a**2/b**2 + (c**2)*(a**2))/ ( a + b + c*(k -a /(b**3))) + c +(k/b - k/a)*c)
    print (y)

#Задание два
y = 0    
print ("Угадай число в диапазоне 0-10")
number = int(input("Введите своё число "))
y = random.randint(0, 10)
while number != y:
    print ("Не то число, попробуйте снова")
    number = int(input("Введите своё число "))
print ("Великолепно, вы угадали")


