#lang racket

#|
    Написать программу, реализующую метод быстрой сортировки
|#

(define (quick-sort arr)
  (cond
    [(< (length arr) 2) arr]
    [else (let ([pivot (car arr)] [rest (cdr arr)])
            (append
             (quick-sort (filter (lambda (x) (< x pivot)) rest))
             (list pivot)
             (quick-sort (filter (lambda (x) (>= x pivot)) rest))
             )
          )
    ]
  )
)

(define (test-qs n)
  (define array (build-list n (lambda (i) (random 100))))
  (displayln array)
  (displayln (quick-sort array))
)

(displayln "Алгоритм быстрой сортировки:")
(test-qs 20)
(newline)