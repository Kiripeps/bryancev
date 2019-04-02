#Задание 1
strok = input("Введите предложение \n")
words = strok.replace(', ' , ' ')
text = words.split(' ')
answer = ''
for i in range(0, len(text)):
    if len(text[i]) > 5:
        answer = answer + ' ' + text[i]
print (answer)

