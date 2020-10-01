#lang racket
(require rnrs/base-6)

(define (routePrice route oil oilPrice)
  (* oilPrice (+ (* (div route 100) oil) (* (mod route 100) (/ oil 100)))))

(define (routeKm)
  (write "расстояние (км) = ")
  (read))

(define (oil)
  (write "расход бензина на 100 км (литр) = ")
  (read))

(define (oilPrice)
  (write "цена бензина за 1 литр (руб) = ")
  (read))

(define (getPrice)
  (write "Вычисление стоимости поездки")
  (newline)
  (routePrice (routeKm) (oil) (oilPrice))
)

(getPrice)