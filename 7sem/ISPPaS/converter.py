# 8 Практическая Информационная безопастность ИКБО-01-17 Крючков М.Р.

import argparse
import math
from PIL import Image


def get_text(args):
    if args.input is not None:
        return args.input
    else:
        try:
            with open(args.file, "r") as f:
                return f.read()
        except:
            print("Can't open a file")
            return False


def text_to_RGB(text):
    prepend = "\x00\r\n\r\n"
    # Добавляем NULL байты и 2 новых строки
    formed_string = prepend + text + "\x00"

    # на пиксель по 3 rgb значения
    pixel_len = math.ceil(len(formed_string) / 3)
    width = math.ceil(math.sqrt(pixel_len))
    # домножаем горизонталь на 4 чтобы избежать добавления бита в 4-х символьную строку
    width = math.ceil(width / 4) * 4
    height = math.ceil(pixel_len / width)

    # добавляем пустые биты чтобы все строки были равномерными и "склейка" была правильная
    while len(formed_string) != (width * height * 3):
        formed_string += "\x00"

    offset = 0  # флаг для перехода по RGB
    matrix = [[0 for x in range(width)] for y in range(height)]

    for y in range(height - 1, -1, -1):  # проходимся снизу на вверх
        for x in range(0, width):  # проходимся слева направо
            # проставляем Unicode символу строки
            r = ord(formed_string[offset + 2])
            g = ord(formed_string[offset + 1])
            b = ord(formed_string[offset])
            matrix[y][x] = (r, g, b)
            offset += 3

    return matrix


def matrix_to_bmp(matrix, filename):
    height = len(matrix)
    width = len(matrix[0])
    image = Image.new("RGB", (width, height))
    pixels = image.load()

    for y in range(height):
        for x in range(width):
            # добавляем пиксели в зависимости от значений RGB
            pixels[x, y] = matrix[y][x]

    try:
        image.save(filename, "bmp")
    except:
        return False
    return True


def main():
    argument_parser = argparse.ArgumentParser(
        description="Convert text to bmp.")
    group = argument_parser.add_mutually_exclusive_group(required=True)
    group.add_argument("-i", "--input", type=str, help="Input text from cli")
    group.add_argument("-f", "--file", type=str, help="Input text from file")
    argument_parser.add_argument(
        "-b", "--bitmap", type=str, help="Save image as bitmap")
    argument_parser.add_argument(
        "-t", "--text", type=str, help="Save rgb values to file")
    argument_parser.add_argument(
        "-p", "--pixels", action="store_true", help="Print RGB values")
    args = argument_parser.parse_args()

    text = get_text(args)

    if text is not False:
        matrix = text_to_RGB(text)
        if args.bitmap is not None:
            if matrix_to_bmp(matrix, args.bitmap):
                print("Saved as bitmap in {}".format(args.bitmap))
            else:
                print("Failed to save as bitmap")


if __name__ == "__main__":
    main()
