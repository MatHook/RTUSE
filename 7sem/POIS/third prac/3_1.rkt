#lang racket

#|
  Есть три числа. Построить список из кубов этих чисел,
  если все три числа – нечетные, возвратить сумму чисел – иначе.
|#

(define (pow3 x) (* x x x))

(define (listToPow list1)
  (if (and (= (remainder (car list1) 2) 0)
           (= (remainder (car (cdr (cdr list1))) 2) 0))
      (list (pow3(car list1)) (pow3(car (cdr list1))) (pow3(car (cdr (cdr list1)))))
      (+ (car list1) (car (cdr list1)) (car (cdr (cdr list1)))))
)

(displayln (listToPow (list 10 20 40)))
(displayln (listToPow (list 5 11 33)))