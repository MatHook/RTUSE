#lang racket

(display "Вычисление объема куба.\n")
(display "Введите длину ребра (см) и нажмите клавишу <Enter> = ")
(let ([num (read (current-input-port))])
    (printf "Объем куба: ~a куб.см.\n" (expt num 3))
)
