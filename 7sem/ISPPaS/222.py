import sys

specialChar = 'А'

ALPHABET = [
 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Э', 'Ю', 'Я'
]

def textToBigram(text):
  result = []
  ends = ""
  i = 0

  if len(text)%2 != 0:
    text += "А"
  while True:
    x1 = replaceSymbol(text[i])
    x2 = replaceSymbol(text[i+1])
    if x1 != x2:
      result.append([x1, x2])
      i += 2
    else:
      result.append([x1, specialChar])
      i += 1
    if i >= len(text)-1:
      break
  return result

def replaceSymbol(symbol):
  if symbol == 'Ь':
    symbol = 'Ъ'
  if symbol == 'Й':
    symbol = 'И'
  if symbol == 'Ё':
    symbol = 'Е'
  
  return symbol

def generateMatrix(key):
  m = []
  k = 0 
  a = 0
  
  for i in range(5):
    m.append([])
    for j in range(6):
      if k < len(key):
        symbol = key[k]
        symbol = replaceSymbol(symbol)
        m[i].append(symbol)
        ALPHABET.remove(symbol)
        k += 1
      else:
        m[i].append(ALPHABET[a])
        a += 1
  return m

def encode(matrix, text):
  result = []
  resultBigram = []
  i = 0 
  
  text = Chiper.textToBigram(text)
  
  for bigram in text:
    x1 = bigram[0]
    x2 = bigram[1]
  
    indexes = [[-1, -1], [-1, -1]]
    
    for j in range(len(matrix)):
      line = matrix[j]
      if x1 in line:
        indexes[0] = [j, line.index(x1)]
      if x2 in line:
        indexes[1] = [j, line.index(x2)]
      
    done = False
    if indexes[0][0] == indexes[1][0]:
      resultBigram = [
        matrix[indexes[0][0]][(indexes[0][1]+1)%6],
        matrix[indexes[1][0]][(indexes[1][1]+1)%6]
      ]
      done = True
    if indexes[0][1] == indexes[1][1]:
      resultBigram = [
        matrix[(indexes[0][0]+1)%5][indexes[0][1]],
        matrix[(indexes[1][0]+1)%5][indexes[1][1]]
      ]
      done = True
    if not done:
      resultBigram = [
        matrix[indexes[0][0]][indexes[1][1]],
        matrix[indexes[1][0]][indexes[0][1]]
      ]
    result.append("".join(resultBigram))
  return "".join(result)

def decode(matrix, text):
  result = []
  bigrams = textToBigram(text)
  
  print(*matrix, sep='\n')

  for bigram in bigrams:
    x1 = bigram[0]
    x2 = bigram[1]
    
    indexes = [[-1, -1], [-1, -1]]
  
    for j in range(len(matrix)):
      line = matrix[j]
      if x1 in line:
        indexes[0] = [j, line.index(x1)]
      if x2 in line:
        indexes[1] = [j, line.index(x2)]
    done = False
    if indexes[0][0] == indexes[1][0]:
      resultBigram = [
        matrix[indexes[0][0]][(indexes[0][1]-1)%6],
        matrix[indexes[1][0]][(indexes[1][1]-1)%6]
      ]
      done = True
    if indexes[0][1] == indexes[1][1]:
      resultBigram = [
        matrix[(indexes[0][0]-1)%5][indexes[0][1]],
        matrix[(indexes[1][0]-1)%5][indexes[1][1]]
      ]
      done = True
    if not done:
      resultBigram = [
        matrix[indexes[0][0]][indexes[1][1]],
        matrix[indexes[1][0]][indexes[0][1]]
      ]
    result.append("".join(resultBigram))
  return "".join(result)

if __name__ == '__main__':
  args = sys.argv
  if len(args) < 4:
    print("Неверное количество аргументов")
    exit()
  if (args[1] == "encode"):
    print(encode(generateMatrix(args[2]), args[3]))
    exit()
  if (args[1] == "decode"):
    print(decode(generateMatrix(args[2]), args[3]))
    exit()