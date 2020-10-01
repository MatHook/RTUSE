#lang racket

(define (getNumber1)
  (write "Введите первое число: ")
  (newline)
  (read)
)

(define (getNumber2)
  (write "Введите второе число: ")
  (newline)
  (read)
)

(define (analyzeNumbers num1 num2)
  (if (> num1 num2)
      (printf "~a больше ~a" num1 num2)
      (if (< num1 num2)
          (printf "~a меньше ~a" num1 num2)
          (printf "~a равно ~a" num1 num2)
      )
  )
)

(define (getRes)
  (write "Проанализируем два числа")
  (newline)
  (analyzeNumbers (getNumber1) (getNumber2))
)

(getRes)