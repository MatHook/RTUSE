from PIL import Image
import os

BITS = 8


def text_to_bin(init):
    return ''.join(str(format(ord(el), '0{}b'.format(BITS))) for el in init)


def bin_to_text(init):
    m = [init[i:i + BITS] for i in range(0, len(init), BITS)]
    return ''.join(chr(int(str(el), 2)) for el in m)


def decode(path, num):
    img = Image.open(path)
    rgb_im = img.convert('RGB')
    pixels = rgb_im.load()
    w, h = rgb_im.size

    bin = ''
    pix_row = 0

    for i in range(num):
        rgb = list(pixels[i % w, pix_row])

        for comp in rgb:
            bin += '1' if comp % 2 == 1 else '0'

        if i % w == 0 and i != 0:
            pix_row += 1

    print('Result of decode: \n ', bin_to_text(bin))


def encode(path, text):
    img = Image.open(path)
    rgb_im = img.convert('RGB')
    pixels = rgb_im.load()
    w, h = rgb_im.size

    bin = text_to_bin(text)
    iterator = iter(bin)
    print('You can encode {} symbols'.format(w * h * 3 // BITS))

    pix_row = 0
    pix_col = 0

    for i in range(0, len(bin), 3):
        rgb = list(pixels[pix_col % w, pix_row % h])

        for j in range(len(rgb)):
            digit = next(iterator, '')

            if digit == '0' and rgb[j] % 2 != 0:
                rgb[j] = (rgb[j] - 1) % 256
            elif digit == '1' and rgb[j] % 2 != 1:
                rgb[j] = (rgb[j] - 1) % 256

        pixels[pix_col % w, pix_row % h] = tuple(rgb)
        pix_col += 1

        if pix_col % w == 0:
            pix_row += 1

    save_name = os.path.split(path)
    save_name = save_name[1].split('.')[0] + '-encoded'

    rgb_im.save('{}.bmp'.format(save_name))
    print('Img saved: {}.bmp'.format(save_name))


choice = input('1 - encode | 2 - decode \n')

if choice == '1':
    path = input('Input path: ')
    assert os.path.exists(path), 'File not found: ' + str(path)
    text = input('Input text: ')
    encode(path, text)

if choice == '2':
    path = input('Input path: ')
    assert os.path.exists(path), 'File not found: ' + str(path)
    num = int(input('Input count of checking pixels: \n'))
    decode(path, num)
