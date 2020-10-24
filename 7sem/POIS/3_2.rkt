#lang racket

#|
  Написать функцию, которая для заданных
  координат X1,Y1 и X2,Y2 возвращает расстояние между ними.
  Координаты могут иметь отрицательные значение.
|#

(define (square x) (* x x))

(define (enter message)
  (display message)
  (read)
)

(define (getLength list1 list2)
  (display "Расстояние: ")
  (display (sqrt(+ (square (- (car list2) (car list1)))
                   (square (- (car (cdr list2)) (car(cdr list1))))
                )
           )
  )
  (newline)
)

(getLength (list (enter "Введите X1: ") (enter "Введите Y1: "))
           (list (enter "Введите X2: ") (enter "Введите Y2: "))
)