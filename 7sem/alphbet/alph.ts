const alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".split("");

var crypt = (rev: any, debug: Boolean, word: any, key: string) => {
  let result = "";
  let i = 0;
  let current;

  for (let c of word) {
    if (rev === 1) {
      current =
        alphabet[
          (alphabet.indexOf(c) + rev * alphabet.indexOf(key[i % key.length])) %
            33
        ];
    } else if (rev === -1) {
      current =
        alphabet[
          (alphabet.length +
            (alphabet.indexOf(c) +
              rev * alphabet.indexOf(key[i % key.length]))) %
            33
        ];
    }

    if (debug) {
      console.log(
        c +
          " + " +
          key[i % key.length] +
          " = " +
          current
      );
    }

    result += current;
    i += 1;
  }

  console.log("Result: " + result);
};

crypt(1, true, "цезарь", "ключ");

crypt(-1, true, "брёчыз", "ключ");
