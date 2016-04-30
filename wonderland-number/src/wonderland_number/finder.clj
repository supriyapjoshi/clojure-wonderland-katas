(ns wonderland-number.finder)

(def wonderland-number-check 
  ;;Function to return a function for number check with original
  (fn [original]
      (fn [number]
        (let [num-to-check (* original number)]
          (if (= ( set (str original)) (set (str num-to-check)) ) original nil))
        )))

(def validator 
  ;;Final validator function to check that all the checks are valid i.e. all the
  ;;multiplied numbers have same digits as original
  (fn [original] (fn [coll] (if (some nil? coll) nil original)))
  )

(def wonderland-number-function 
  ;;Function to generate the numbers that map to original
 ;;after the multiplication with  2, 3, 4, 5, 6
  (fn [original]
    (let [check-num (wonderland-number-check original )
          validate (validator original) ]
   (validate (map check-num (range 2 7) ) ) )
    ))

(def wonderland-basic-range
  ;;Function to generate a basic number range
  (fn [] (range 100000 999999)))

(defn wonderland-number []
  ;; calculate me
  (let [wonderland-range (wonderland-basic-range)]
    (first (filter (comp not nil?) (map wonderland-number-function
                                        wonderland-range) ))))
