import os
Menu = '0 - Выход из программы\n1 - Количество файлов в директории\n2 - Сортировка данных файла products.txt по цене\n'
Menu2 = '0 - Назад\n1 - Уменьшить количество продуктов\n2 - Сохранить в исходный файл\n3 - Сохранить в указанную директорию\n'
flagIn = ''
productsList = []

def filesCount():
    link = str(input('Введите путь к директории\n'))
    print("Количество файлов в директории:" + str(len(next(os.walk(link))[2])))
          
def fileReading(productsList):
    global first_str
    with open('C:/users/Кирилл/Desktop/products.txt') as f:
        for line in f:
            productsList.append([x for x in line.rstrip('\n').split(';')])
    first_str = productsList[0]
    del productsList[0]
    return productsList

def listSorting(productsList):
    productsList.sort(key=lambda i: int(i[2]))
    return productsList
    
def quantityReduction(productsList, numbers, count):
    for i in productsList:
        for j in numbers:
            if i[0] == j:
                i[3] = str(int(i[3]) - int(count))
    return productsList

def saveNewFile(productsList):
    link = input('Введите путь к директории: \n')
    with open(link+"\products.txt", "w") as f:
        f.write(';'.join(first_str)+'\n')
        i = 0
        while i<len(productsList):
            string = ';'.join(productsList[i])
            f.write(string+'\n')
            i+=1
    print('Сохранено')
          
    
def saveBack(productsList):
    with open("C:/users/Кирилл/Desktop/products.txt", "w") as f:
        f.write(';'.join(first_str)+'\n')
        i = 0
        while i<len(productsList):
            string = ';'.join(productsList[i])
            f.write(string+'\n')
            i+=1
    print('Сохранено')

                    
while True:
    flagIn = str(input(Menu))
    if (flagIn == '1'):
        filesCount()            
        print('Хотите продолжить?')
        flagIn = str(input())
        if (flagIn == '1') or (flagIn == 'Y') or (flagIn == 'yes'):
            print('')
        elif (flagIn=='0') or (flagIn=='N') or (flagIn=='no'):
            break
         
    elif (flagIn == '2'):
        productsList = fileReading(productsList)
        print(first_str)
        productsList = listSorting(productsList)
        print('Отсортированные данные:')
        for line in productsList:
            print(line)
        
        
        while True:
            flagIn2 = str(input(Menu2))
            if (flagIn2 == '1'):

                numbers = input('Введите номера товаров, количество которых нужно уменьшить:\n').split()
                count = input('Введите число, на которое надо уменьшить\n')
                productsList = quantityReduction(productsList, numbers, count)
                
                print('Новый список:')
                for line in productsList:
                    print(line)

            if (flagIn2 == '2'):
                saveBack(productsList)
            if (flagIn2 == '3'):
                saveNewFile(productsList)
            if (flagIn2 == '0'):
                break   
    elif (flagIn=='0'):
        break
