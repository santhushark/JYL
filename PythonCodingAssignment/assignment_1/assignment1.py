# Program solutions for all the questions
yes = 'y'


def generate_output_list(input_list):
    minimum = min(input_list)
    maximum = max(input_list)
    output_list = []
    if minimum == maximum:
        output_list = [0] * 10
        print("OUTPUT NUMBER LIST", output_list)
        return
    dif_div = int(((maximum + 1) - (minimum - 1)) / 10)
    print(dif_div)
    if dif_div >= 1:
        output_list.append(minimum)
        for x in range(1, 10):
            output_list.append((output_list[-1] + dif_div))
    print("OUTPUT NUMBER LIST", output_list)


def merge_dictionaries(*dictionary_args):
    result = {}
    for dictionary in dictionary_args:
        result.update(dictionary)
    return result


def reversed_string(str_to_reverse):
    reversed_str = ""
    for ch in str_to_reverse:
        reversed_str = ch + reversed_str
    return reversed_str


def fibonacci_normal(count):
    x, y = int(0), int(1)
    print(x)
    print(y)
    for num in range(count - 2):
        temp_var = x + y
        print(temp_var)
        x = y
        y = temp_var


def fibonacci_recurssive(count):
    if count <= 1:
        return count
    return fibonacci_recurssive(count - 1) + fibonacci_recurssive(count - 2)


while True:
    question_number = input("Enter the question Number to execute program: ")
    if question_number == "1":
        print("QUESTION: 1")
        char_list = ["x", "y", "z"]
        string = "xyz"
        print("MULTIPLIED LIST: ", char_list * 5)
        print("MULTIPLIED STRING: " + string * 5)

    if question_number == "2":
        print("QUESTION: 2")
        number_list = [[x for x in range(8)], [x * x for x in range(8)], [x * x * x for x in range(8)]]
        print("LIST of LISTS: ", number_list)

    if question_number == "3":
        print("QUESTION: 3")
        input_number_list = [int(x) for x in input("ENTER numbers separated by space: ").split()]
        print("INPUT NUMBER LIST: ", input_number_list)
        generate_output_list(input_number_list)

    if question_number == "4":
        print("QUESTION: 4")
        months = {"jan": "january", "feb": "february", "mar": "march", "apr": "april", "may": "may", "jun": "june"}
        new_months = sorted(months.items(), key=lambda m: m[1])
        print(new_months)

    if question_number == "5":
        print("QUESTION: 5")
        dict1 = {}
        dict2 = {}
        dict3 = {}
        dict_final = {}
        n = input("Enter the number of key value pairs you want to have in each dictionary: ")
        print("input space separated key value pairs for DICT1")
        for i in range(int(n)):
            key_val = input().split()
            dict1[key_val[0]] = key_val[1]
        print("Dictionary1: ", dict1)
        print("input space separated key value pairs for DICT2")
        for i in range(int(n)):
            key_val = input().split()
            dict2[key_val[0]] = key_val[1]
        print("Dictionary2: ", dict2)
        print("input space separated key value pairs for DICT3")
        for i in range(int(n)):
            key_val = input().split()
            dict3[key_val[0]] = key_val[1]
        print("Dictionary3: ", dict3)
        dict_final = merge_dictionaries(dict1, dict2, dict3)
        print(dict_final)

    if question_number == "6":
        print("QUESTION: 6")
        ip_str = input("Enter the string you want to reverse: ")
        rev_str = reversed_string(ip_str)
        print("REVERSED string : ", rev_str)

    if question_number == "7":
        print("QUESTION: 7")
        details = {
            "home": ["Hyderabad", "Lingampally", "Ph: 1234567890"],
            "office": ["Maharashtra", "Mumbai", "Ghatkopar", "Ph : 5432167809", "Pin: 400043"],
            "OOI": ["Singapore", "Ph : 09876345"]
        }
        for k, v in details.items():
            for string in v:
                temp_str = string.replace(" ", "")
                if "Ph:" in temp_str:
                    print(string)

    if question_number == "8":
        print("QUESTION: 8")
        print("Enter 2 numbers ")
        num1 = int(input("Number 1 : "))
        num2 = int(input("Number 2 : "))
        if num2 > num1:
            temp = num1
            num1 = num2
            num2 = temp
        reminder = int("1")
        while reminder:
            reminder = num1 % num2
            num1 = num2
            num2 = reminder
        print("The GCD is ", num1)

    if question_number == "9":
        print("QUESTION: 9")
        n = int(input("Enter the value for n : "))
        q = int(input("Enter the value for q: "))
        sum_total = int("0")
        n += 1
        for i in range(n):
            sum_total = sum_total + pow(i, q)
        print("The total sum is : ", sum_total)

    if question_number == "10":
        print("QUESTION: 10")
        print ("The numbers between 1-100 divisible by either 3 or 5  are: ")
        for i in range(101):
            if i % 3 == 0:
                if i % 5 != 0:
                    print(i)
            else:
                if i % 5 == 0:
                    print(i)

    if question_number == "11":
        print("QUESTION: 11")
        n = int(input("Enter the number of elements you want in the fibonacci sequence: "))
        print("1) NORMAL METHOD       2) RECURSIVE METHOD")
        choice = int(input("Enter CHOICE:"))
        if choice == 1:
            print("NORMAL EXECUTION")
            fibonacci_normal(n)
        elif choice == 2:
            print("RECURSIVE EXECUTION")
            for i in range(n):
                print(fibonacci_recurssive(i))
        else:
            print("NO METHOD ASSOCIATED WITH THE CHOICE YOU HAVE MADE")

    if question_number == "12":
        print("QUESTION: 12")

        choice = input("PRESS y to execute one more program or any other character to terminate: ")
        if choice != yes:
            print("TERMINATING EXECUTION")
            break
