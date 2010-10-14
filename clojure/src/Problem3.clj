; The prime factors of 13195 are 5, 7, 13 and 29.
;
; What is the largest prime factor of the number 600851475143 ?
;******************************************************************************************************

;first attempt
(defn factor [f n]
  "how many times does is f a factor of n. returns nil if not a factor"
  (let [t (/ n f)] (if (ratio? t) nil t))
  )

(defn prime? [n]
  "is a number a prime number"
  (cond
    (= n 1) false
    (and (even? n) (> n 2)) false
    (= n 2) true
    true (not-any? #(factor % n) (range 3 (- n 1)))
  ))

(defn largest-prime-factor [num]
  "finds the largest prime factor of a number passed in"
  (if (prime? num) num
    (loop [n num cur 2 largest nil]
      (let [f (factor cur n)]
        (cond
          (and f (prime? f)) f ;f must be largest
          (and f (prime? cur)) (recur (identity n) (inc cur) (identity cur)) ;recurse w/ new prime
          (and f (<= f cur)) largest ;stop here
          (prime? num) num ;the number is a prime - should check this ahead of time!
          true (recur (identity n) (inc cur) (identity largest)) ;recurse w/ no new prime
  )))))

(println (time (largest-prime-factor 600851475143)))