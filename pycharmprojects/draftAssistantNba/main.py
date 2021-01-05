#from fuzzywuzzy import fuzz


def find_rank(name, list):
    count1 = 0
    for item in list:
        if item == name:
            return count1
        else:
            count1 = count1 + 1
    return 0




temp = []
temp1 = []
array = []

with open('espnRankings.txt') as my_file:
    temp = my_file.readlines()

with open('hashtagbasketballrankings.txt') as my_file:
    temp1 = my_file.readlines()

espnRankings = [item.lower() for item in temp]
hashtagRankings = [item.lower() for item in temp1]

for i in range(len(hashtagRankings)):
    hashtagRankings[i] = hashtagRankings[i].rstrip("\n")

temp = ""
print("To get best 10 available players type 2")
flag = False
while temp != "exit":
    temp = input("Enter name: ")
    if flag is True:
        flag = False
    if temp == "2":
        print("The 10 best available players are: "+"\n")
        count = 0
        i = 0
        while count != 10:
            if hashtagRankings[i] != "":
                ranking = find_rank(hashtagRankings[i], hashtagRankings)+1
                print(hashtagRankings[i]+ " Ranking: " + str(ranking) + "\n")
                count = count+1
                i = i + 1
            else:
                i = i + 1
    else:
        index1 = 0
        for x in hashtagRankings:
            if temp in x and x != "":
                hashtagRankings[index1] = ""
                flag = True
                break
            index1 = index1 + 1
        if flag is False:
            print("Player not found. Please try again.")

