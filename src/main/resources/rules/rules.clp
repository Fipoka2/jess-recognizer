;; import
(import model.Person)
(import model.JessResult)
;;
(deftemplate Person (declare (from-class Person)))
(deftemplate JessResult (declare (from-class JessResult)))




(defrule check_persons1
    ?person1 <- (Person {name == "Павел"})
    =>
    (add (new JessResult ?person1.id "message"))
)

(defrule check_persons2
    ?person1 <- (Person {name == "Иван"})
    =>
    (add (new JessResult ?person1.id "message"))
)

(defrule check_persons3
    ?person1 <- (Person {name == "test1"})
    ?person2 <- (Person {name == "test2"})
    =>
    (add (new JessResult ?person1.id "message1"))
    (add (new JessResult ?person2.id "message1"))
)