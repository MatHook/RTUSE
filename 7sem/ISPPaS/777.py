import numpy as np


def read(msg, grid):
  result = ''
  for i in range(grid.shape[0]):
    for j in range(grid.shape[1]):
      if grid[i, j]:
        result += msg[i, j]
  return result


def read_all(msg, grid):
  result = ''
  for __ in range(4):
    result += read(msg, grid)
    grid = np.rot90(grid)
  return result


def write(msg, grid, result=None):
  if result is None:
    result = [[' ' for __ in range(grid.shape[1])] for __ in range(grid.shape[0])]
  if msg is None or isinstance(msg, str):
    msg = list(msg)
  for i in range(grid.shape[0]):
    for j in range(grid.shape[1]):
      if grid[i, j]:
        result[i][j] = msg.pop(0)
  return result, msg


def write_all(msg, grid):
  result = None
  for __ in range(4):
    result, msg = write(msg, grid, result)
    grid = np.rot90(grid)
  return result


if __name__ == "__main__":
  grid = np.matrix('0 0 1 0; 0 0 0 1; 0 0 1 0; 1 0 0 0')
  print(f'Grid: \n {grid}')

  msg = 'Hello world'
  msg_stack = list(msg + ' ' * (4 * 4))
  msg_grid = np.array([np.array([msg_stack.pop(0) for _ in range(grid.shape[1])]) for __ in range(grid.shape[0])])
  print(f'Message: {msg}')

  encoded=read_all(msg_grid, grid)
  print(f'Encoded: {encoded}')

  decoded=write_all(encoded, grid)
  print(f'Decoded: {"".join(c for line in decoded for c in line)}')