class Shared {
  constructor() {
    this.values = [];
    this.increase = false;
    this.alternate = false;
  }


  serialize() {
    return JSON.stringify({
      values: this.values,
      increase: this.increase,
      alternate: this.alternate
    });
  }

  static deserialize(data) {
    const pars = new Shared();

    pars.values = data.values;
    pars.increase = data.increase;
    pars.alternate = data.alternate;

    return pars;
  }


  static fromString(string) {
    const tokens = string.split(' ');

    const pars = new Shared();

    pars.values = tokens;

    return pars;
  }

  isIncrease() {
    const pars = this;
    var i = 0;

    while( i < pars.values.length - 1 ) { // пока i не дойдет до конечного идекса массива будет крутиться в цикле
      if (pars.values[i] < pars.values[i + 1]) { // если "первый" элемент меньше "следующего" тогда заходим в условие
        pars.increase = true; // ставим значение true для pars.increase
      }
      else { // если условние не прошло тогда заходим в else
        pars.increase = false // и ставим значение false
        return pars.increase;
      }
      i++; // добавляем +1 к i чтобы проверять следующие элементы и не крутиться бесконечно
    }
    return pars.increase;
  }

  isAlternating() {
    const pars = this;
    var i = 0;
    var count = 0;

    while( i < pars.values.length - 1 ) {
      if (pars.values[i]*pars.values[i + 1]<0) {
        count++;
      } else break;
      i++;
    }

    if (count === pars.values.length - 1) {
      pars.alternate = true;
    }

    return pars.alternate;
  }

  getResult() {
    const { values: tokens, increase: flag1, alternate: flag2 } = this;

    try {
      return `${tokens} Возрастает: ${this.isIncrease()}, Чередуется: ${this.isAlternating()} `;
    } catch {
      return 0;
    }
  }
}

module.exports = {
  Parser: Shared,
}
