#lang racket

#|
  Дан список lst. Написать функцию, которая для случая,
  когда первый элемент lst является списком,
  возвращает список из последнего элемента
  lst в качестве головы и первого элемента lst
  в качестве хвоста, список lst,
  из которого удален второй элемент – иначе.
|#

(define (last_elem lst) (list-ref lst (- (length lst) 1)))

(define (getSpecificList)
  (displayln "Введите список: ")
  (define list_in (read))

  (if (list? (car list_in))
             (printf "Первый элемент списка – список\nРезультат: ~a"
                     (cons
                      (last_elem list_in)
                      (car list_in)
                     )
             )
             (printf "Первый элемент списка – не список\nРезультат: ~a"
                     (cons
                      (car list_in)
                      (cdr (cdr list_in))
                     )
             )
  )
)

(getSpecificList)