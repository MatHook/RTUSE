class Calculator {
  constructor() {
    this.values = ['', ''];
    this.operator = '';
  }

  /* ------------------------------------------- */

  serialize() {
    return JSON.stringify({
      values: this.values,
      operator: this.operator
    });
  }

  static deserialize(data) {
    const calc = new Calculator();

    calc.values = data.values;
    calc.operator = data.operator;

    return calc;
  }

  /* ------------------------------------------- */

  static fromValues(leftValue, operator, rightValue) {
    const calc = new Calculator();

    calc.values = [leftValue, rightValue];
    calc.operator = operator;

    return calc;
  }

  static fromString(string) {
    const tokens = string.split(' ');

    const calc = new Calculator();

    calc.values = [tokens[0], tokens[2]];
    calc.operator = tokens[1];

    return calc;
  }

  /* ------------------------------------------- */

  getResult() {
    const { values: [lv, rv], operator } = this;

    try {
      return eval(`${lv} ${operator} ${rv}`);
    } catch {
      return 0;
    }
  }
}

module.exports = {
  Calculator,
}
