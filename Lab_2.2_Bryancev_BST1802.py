# Задание 2
my_string = "ф;И;О;Возраст;Категория;_Иванов;Иван;Иванович;23 года;Студент 3 курса;_Петров;Семен;Игоревич;22 года;Студент 2 курса"
my_string = my_string.replace('_','')
words = my_string.split(';')
headline = words[:3] + words[3:4] + words[4:5]# список заголовков
del words[0:5]
print((headline[0]+ headline[1] + headline[2]).center(26) + "  " + headline[3].center(8) + "  " + headline[4].center(15))

for i in range(0, len(words)):
    if i%5 == 0:
        print(words[i].ljust(8) + " " + words[i+1].ljust(8) + " " + words[i+2].ljust(8) + "  " + words[i+3].ljust(8) + "  " + words[i+4].ljust(10))

