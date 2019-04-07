;; importing classes
(import model.Person)
(import model.JessSingleResult)
(import model.JessCoupleResult)
;; defining deftemplates
(deftemplate Person (declare (from-class Person)))
(deftemplate JessSingleResult (declare (from-class JessSingleResult)))
(deftemplate JessCoupleResult (declare (from-class JessCoupleResult)))


(defrule check
    ?person1 <- (Person { hairColor == "каштановый" && nationality == "француз" && (eyeColor == "зелёный" || eyeColor == "синий")})
    =>
    (add (new JessSingleResult "Правило 1" ?person1.id))
)

(defrule check_persons2
    ?person1 <- (Person {hairColor != "тёмный" && eyeColor != "синий" && hairColor != eyeColor})
    =>
    (add (new JessSingleResult "Правило 2" ?person1.id))
)

(defrule check_persons3
    ?person1 <- (Person {(eyeColor == "карий" || eyeColor == "синий") && nationality == "немец" && hairColor != "светлый"})
    ?person2 <- (Person {(eyeColor == "зелёный" || (eyeColor == "карий" && hairColor == "каштановый") ) && hairColor == person1.hairColor})
    =>
    (add (new JessCoupleResult "правило 3" ?person1.id ?person2.id))
)