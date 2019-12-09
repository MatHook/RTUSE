class Shared {
  constructor() {
    this.values = [];
    this.increase = false;
  }


  serialize() {
    return JSON.stringify({
      values: this.values,
      increase: this.increase
    });
  }

  static deserialize(data) {
    const pars = new Shared();

    pars.values = data.values;
    pars.increase = data.increase;

    return pars;
  }


  static fromString(string) {
    const tokens = string.split(' ');

    const pars = new Shared();

    pars.values = tokens;

    return pars;
  }

  isIncrease(data) {
    const pars = this;
    var i = 0;

    // 5 6 4
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


  getResult() {
    const { values: tokens, increase: flag } = this;

    try {
      return `${tokens} increasing: ${this.isIncrease()}`;
    } catch {
      return 0;
    }
  }
}

module.exports = {
  Parser: Shared,
}
