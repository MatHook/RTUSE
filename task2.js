var a = [  
  [1, 0],  
  [0, 1],  
  [1, 1]  
]

var dx = 0, dy = 0

for (var d of a) {
  if (d[0]) {
    if (dx) {
      d[0] = -1
      dx = 0
    } else {
      dx = 1
    }
  }

  if (d[1]) {
    if (dy) {
      d[1] = -1
      dy = 0
    } else {
      dy = 1
    }
  }
}

return dx || dy ? null : a
