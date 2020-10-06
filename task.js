const data = [
  {
    text: "test",
    geometry: [],
  },
];

const dictionary = ["James", "Bond"];

function text(data, dictionary) {
  if (data && data.length) {
    if (!Array.isArray(data) || !Array.isArray(dictionary) || !data.length) {
      return "Unreadable message";
    }

    if (!data.every((x) => dictionary.includes(x.text))) {
      return "Unreadable message";
    }

    if (
      !data.every(
        (x) => typeof x.text === "string" && Array.isArray(x.geometry)
      )
    ) {
      return "Unreadable message";
    }

    if (
      !data.every((x) => isFinite(x.geometry[0]) && isFinite(x.geometry[1]))
    ) {
      return "Unreadable message";
    }

    return data
      .sort((a, b) => a.geometry[0] - b.geometry[0])
      .map((x) => x.text)
      .join(" ");
  }
}

console.log(text(data, dictionary));
