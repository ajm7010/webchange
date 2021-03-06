(ns webchange.editor-v2.graph-builder.graph.data.magic-hat.source)

(def data {:assets        [{:url "/raw/img/library/magic-hat/background.jpg", :type "image"}
                           {:url "/raw/audio/l2/a8/L2_A8_Mari.m4a", :type "audio"}
                           {:url "/raw/audio/l2/mari-chants.m4a", :size 5, :type "audio", :alias "mari chants"}],
           :objects       {
                           :background {:type "background", :src "/raw/img/library/magic-hat/background.jpg"},
                           :box1
                                       {:type       "transparent",
                                        :x          1270,
                                        :y          800,
                                        :width      671,
                                        :height     633,
                                        :scene-name "box1",
                                        :transition "box1",
                                        :actions    {:click {:id "pick-box", :on "click", :type "action", :params {:target "box1"}, :unique-tag "click"}},
                                        :anim       "idle2",
                                        :loop       true,
                                        :name       "boxes",
                                        :scale-x    0.25,
                                        :scale-y    0.25,
                                        :skin       "qwestion",
                                        :speed      0.3,
                                        :start      true},
                           :box2
                                       {:type       "transparent",
                                        :x          1460,
                                        :y          770,
                                        :width      671,
                                        :height     633,
                                        :scene-name "box2",
                                        :transition "box2",
                                        :actions    {:click {:id "pick-box", :on "click", :type "action", :params {:target "box2"}, :unique-tag "click"}},
                                        :anim       "idle2",
                                        :loop       true,
                                        :name       "boxes",
                                        :scale-x    0.25,
                                        :scale-y    0.25,
                                        :skin       "qwestion",
                                        :speed      0.3,
                                        :start      true},
                           :box3
                                       {:type       "transparent",
                                        :x          1660,
                                        :y          790,
                                        :width      671,
                                        :height     633,
                                        :scene-name "box3",
                                        :transition "box3",
                                        :actions    {:click {:id "pick-box", :on "click", :type "action", :params {:target "box3"}, :unique-tag "click"}},
                                        :anim       "idle2",
                                        :loop       true,
                                        :name       "boxes",
                                        :scale-x    0.25,
                                        :scale-y    0.25,
                                        :skin       "qwestion",
                                        :speed      0.3,
                                        :start      true},
                           :hat
                                       {:type       "animation",
                                        :x          925,
                                        :y          555,
                                        :width      473,
                                        :height     511,
                                        :scene-name "magic-hat",
                                        :transition "hat",
                                        :anim       "idle",
                                        :loop       true,
                                        :name       "hat",
                                        :scale-x    1,
                                        :scale-y    1,
                                        :speed      0.35,
                                        :start      true},
                           :letter1
                                       {:type           "transparent",
                                        :x              1175,
                                        :y              570,
                                        :width          200,
                                        :height         130,
                                        :align          "center",
                                        :fill           "white",
                                        :font-family    "Lexend Deca",
                                        :font-size      160,
                                        :scale-x        1,
                                        :scale-y        1,
                                        :text           "",
                                        :vertical-align "middle"},
                           :letter2
                                       {:type           "transparent",
                                        :x              1365,
                                        :y              540,
                                        :width          200,
                                        :height         130,
                                        :align          "center",
                                        :fill           "white",
                                        :font-family    "Lexend Deca",
                                        :font-size      160,
                                        :scale-x        1,
                                        :scale-y        1,
                                        :text           "",
                                        :vertical-align "middle"},
                           :letter3
                                       {:type           "transparent",
                                        :x              1565,
                                        :y              560,
                                        :width          200,
                                        :height         130,
                                        :align          "center",
                                        :fill           "white",
                                        :font-family    "Lexend Deca",
                                        :font-size      160,
                                        :scale-x        1,
                                        :scale-y        1,
                                        :text           "",
                                        :vertical-align "middle"},
                           :mari
                                       {:type       "animation",
                                        :x          1500,
                                        :y          370,
                                        :width      473,
                                        :height     511,
                                        :scene-name "mari",
                                        :transition "mari",
                                        :anim       "idle",
                                        :loop       true,
                                        :name       "mari",
                                        :scale-x    0.5,
                                        :scale-y    0.5,
                                        :speed      0.35,
                                        :start      true}
                           },
           :scene-objects [["background"] ["hat" "box1" "box2" "box3" "letter1" "letter2" "letter3"] ["mari"]],
           :actions
                          {
                           :box-jump-in
                                              {:type "parallel",
                                               :data
                                                     [{:id "jump2", :type "animation", :from-params [{:param-property "target", :action-property "target"}]}
                                                      {:data
                                                             [{:type "empty", :duration 500}
                                                              {:to          {:bezier [{:x 960, :y 100} {:x 610, :y 435}], :duration 1.0},
                                                               :type        "transition",
                                                               :from-params [{:param-property "target", :action-property "transition-id"}]}],
                                                       :type "sequence-data"}
                                                      {:id          "idle2",
                                                       :loop        true,
                                                       :type        "add-animation",
                                                       :from-params [{:param-property "target", :action-property "target"}]}]},
                           :boxes-disappear
                                              {:type "parallel",
                                               :data
                                                     [{:skin "qwestion", :type "set-skin", :target "box1"}
                                                      {:skin "qwestion", :type "set-skin", :target "box2"}
                                                      {:skin "qwestion", :type "set-skin", :target "box3"}
                                                      {:type "set-attribute", :target "box1", :attr-name "type", :attr-value "transparent"}
                                                      {:type "set-attribute", :target "box2", :attr-name "type", :attr-value "transparent"}
                                                      {:type "set-attribute", :target "box3", :attr-name "type", :attr-value "transparent"}]},
                           :boxes-jump-out
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "boxes-reset-position", :type "action"}
                                                      {:type "empty", :duration 200}
                                                      {:id "boxes-show-up", :type "action"}
                                                      {:id "boxes-move-to-position", :type "action"}]},
                           :boxes-move-to-position
                                              {:type "parallel",
                                               :data
                                                     [{:to {:bezier [{:x 960, :y 100} {:x 1270, :y 800}], :duration 2.0}, :type "transition", :transition-id "box1"}
                                                      {:to {:bezier [{:x 1055, :y 100} {:x 1460, :y 770}], :duration 2.0}, :type "transition", :transition-id "box2"}
                                                      {:to {:bezier [{:x 1195, :y 100} {:x 1660, :y 790}], :duration 2.0}, :type "transition", :transition-id "box3"}]},
                           :boxes-reset-position
                                              {:type "parallel",
                                               :data
                                                     [{:type "set-attribute", :target "box1", :attr-name "x", :attr-value 610}
                                                      {:type "set-attribute", :target "box1", :attr-name "y", :attr-value 435}
                                                      {:type "set-attribute", :target "box2", :attr-name "x", :attr-value 610}
                                                      {:type "set-attribute", :target "box2", :attr-name "y", :attr-value 435}
                                                      {:type "set-attribute", :target "box3", :attr-name "x", :attr-value 610}
                                                      {:type "set-attribute", :target "box3", :attr-name "y", :attr-value 435}]},
                           :boxes-show-up
                                              {:type "parallel",
                                               :data
                                                     [{:data
                                                             [{:type "set-attribute", :target "box1", :attr-name "type", :attr-value "animation"}
                                                              {:type "empty", :duration 200}
                                                              {:id "come2", :type "animation", :target "box1"}
                                                              {:id "idle2", :loop true, :type "add-animation", :target "box1"}],
                                                       :type "sequence-data"}
                                                      {:data
                                                             [{:type "set-attribute", :target "box2", :attr-name "type", :attr-value "animation"}
                                                              {:type "empty", :duration 200}
                                                              {:id "come2", :type "animation", :target "box2"}
                                                              {:id "idle2", :loop true, :type "add-animation", :target "box2"}],
                                                       :type "sequence-data"}
                                                      {:data
                                                             [{:type "set-attribute", :target "box3", :attr-name "type", :attr-value "animation"}
                                                              {:type "empty", :duration 200}
                                                              {:id "come2", :type "animation", :target "box3"}
                                                              {:id "idle2", :loop true, :type "add-animation", :target "box3"}],
                                                       :type "sequence-data"}]},
                           :check-level
                                              {:type "sequence-data",
                                               :data
                                                     [{:fail     {:type "empty", :duration 100},
                                                       :type     "test-var-scalar",
                                                       :value    3,
                                                       :success
                                                                 {:data
                                                                        [{:type "set-variable", :var-name "correct-answers-in-row", :var-value 0}
                                                                         {:fail     {:type "set-variable", :var-name "current-level", :var-value "hard"},
                                                                          :type     "test-var-scalar",
                                                                          :value    "easy",
                                                                          :success  {:type "set-variable", :var-name "current-level", :var-value "mid"},
                                                                          :var-name "current-level"}],
                                                                  :type "sequence-data"},
                                                       :var-name "correct-answers-in-row"}
                                                      {:fail     {:type "empty", :duration 100},
                                                       :type     "test-var-scalar",
                                                       :value    3,
                                                       :success
                                                                 {:data
                                                                        [{:type "set-variable", :var-name "wrong-answers-in-row", :var-value 0}
                                                                         {:fail     {:type "set-variable", :var-name "current-level", :var-value "easy"},
                                                                          :type     "test-var-scalar",
                                                                          :value    "hard",
                                                                          :success  {:type "set-variable", :var-name "current-level", :var-value "mid"},
                                                                          :var-name "current-level"}],
                                                                  :type "sequence-data"},
                                                       :var-name "wrong-answers-in-row"}]},
                           :count-correct-answer
                                              {:type "sequence-data",
                                               :data
                                                     [{:type "counter", :counter-id "correct-answers-in-row", :counter-action "increase"}
                                                      {:type "set-variable", :var-name "wrong-answers-in-row", :var-value 0}]},
                           :count-wrong-answer
                                              {:type "sequence-data",
                                               :data
                                                     [{:type "counter", :counter-id "wrong-answers-in-row", :counter-action "increase"}
                                                      {:type "set-variable", :var-name "correct-answers-in-row", :var-value 0}]},
                           :current-concept-chant
                                              {:phrase             :task-easy
                                               :phrase-description "Task easy"
                                               :type               "action", :from-var [{:var-name "current-concept", :var-property "mari-chant"}]},
                           :current-concept-sound-x3
                                              {:phrase             :task-hard
                                               :phrase-description "Task hard"
                                               :type               "action", :from-var [{:var-name "current-concept", :var-property "mari-sound-3"}]},
                           :finish-activity
                                              {:type "sequence-data", :data [{:id "magic-hat", :type "finish-activity"} {:type "scene", :scene-id "library"}]},
                           :init-vars
                                              {:type "parallel",
                                               :data
                                                     [{:type "set-variable", :var-name "current-level", :var-value "hard"}
                                                      {:type "set-variable", :var-name "correct-answers-in-row", :var-value 0}
                                                      {:type "set-variable", :var-name "wrong-answers-in-row", :var-value 0}
                                                      {:type "set-variable", :var-name "last-pick-wrong", :var-value false}]},
                           :intro             {:phrase             :intro
                                               :phrase-description "Intro"
                                               :type               "sequence",
                                               :data               ["mari-voice-welcome" "mari-flies-to-hat" "mari-init-wand" "mari-voice-intro"]},
                           :letters-hide
                                              {:type "parallel",
                                               :data
                                                     [{:type "set-attribute", :target "letter1", :attr-name "type", :attr-value "transparent"}
                                                      {:type "set-attribute", :target "letter2", :attr-name "type", :attr-value "transparent"}
                                                      {:type "set-attribute", :target "letter3", :attr-name "type", :attr-value "transparent"}]},
                           :letters-show
                                              {:type "parallel",
                                               :data
                                                     [{:type "set-attribute", :target "letter1", :attr-name "type", :attr-value "text"}
                                                      {:type "set-attribute", :target "letter2", :attr-name "type", :attr-value "text"}
                                                      {:type "set-attribute", :target "letter3", :attr-name "type", :attr-value "text"}]},
                           :mari-flies-to-hat {:type "transition", :to {:x 1075, :y 445, :loop false, :duration 1.5}, :transition-id "mari"},
                           :mari-init-wand    {:type "add-animation", :id "wand_idle", :target "mari", :track 2, :loop true},
                           :mari-says-correct-answer
                                              {:phrase             :correct-answer
                                               :phrase-description "Correct answer"
                                               :type               "action",
                                               :from-var           [{:var-name     "current-concept",
                                                                     :var-property "mari-word"}]},
                           :mari-says-wrong-answer
                                              {:phrase             :wrong-answer
                                               :phrase-description "Wrong answer"
                                               :type               "sequence-data",
                                               :data
                                                                   [{:type "action", :from-var [{:var-name "current-concept", :var-property "mari-word"}]}
                                                                    {:type "empty", :duration 500}
                                                                    {:id "mari-voice-wrong-1", :type "action"}
                                                                    {:type "action", :from-var [{:var-name "current-concept", :var-property "mari-word"}]}
                                                                    {:type "empty", :duration 500}
                                                                    {:type "action", :from-var [{:var-name "current-concept", :var-property "mari-word"}]}
                                                                    {:id "mari-voice-wrong-2", :type "action"}
                                                                    {:type "action", :from-var [{:var-name "current-concept", :var-property "mari-sound"}]}
                                                                    {:type "empty", :duration 500}
                                                                    {:id "mari-voice-wrong-3", :type "action"}
                                                                    {:type "action", :from-var [{:var-name "current-concept", :var-property "mari-sound"}]}]},
                           :mari-tap-hat
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "wand_hit", :type "animation", :track 2, :target "mari"}
                                                      {:id "wand_idle", :loop true, :type "add-animation", :track 2, :target "mari"}]},
                           ;:mari-voice-can-you-find
                           ;{:type "parallel",
                           ; :data
                           ; [{:id "/raw/audio/l2/a8/L2_A8_Mari.m4a", :type "audio", :start 41.323, :volume 0.2, :duration 2.926}
                           ;  {:data [{:end 42.792, :anim "talk", :start 41.453} {:end 44.1, :anim "talk", :start 43.021}],
                           ;   :type "animation-sequence",
                           ;   :track 1,
                           ;   :offset 41.323,
                           ;   :target "mari"}],
                           ; :description "Puedes encontrar este foto"},
                           :mari-voice-intro
                                              {:offset                 6.969,
                                               :phrase-text            "There are lots of magical pictures in the wizards hat.  Listen to the chant, and then touch the picture that completes it.",
                                               :phrase-text-translated "Hay muchas fotos por dentro del sombrero de magos. Escucha el canto, y despues toca la foto que completa el canto!",
                                               :start                  6.969,
                                               :type                   "animation-sequence",
                                               :duration               10.354,
                                               :volume                 0.2,
                                               :audio                  "/raw/audio/l2/a8/L2_A8_Mari.m4a",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 10.85, :anim "talk", :start 7.13} {:end 17.05, :anim "talk", :start 11.433}]},
                           :mari-voice-welcome
                                              {:offset                 0.533,
                                               :phrase-text            "Hello my friend! Did you see the wizard’s hat?"
                                               :phrase-text-translated "Hola mi amigo! Puedes ver el sombrero de magos?",
                                               :start                  0.533,
                                               :type                   "animation-sequence",
                                               :duration               4.538,
                                               :volume                 0.2,
                                               :audio                  "/raw/audio/l2/a8/L2_A8_Mari.m4a",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 2.083, :anim "talk", :start 0.918} {:end 4.799, :anim "talk", :start 2.629}]},
                           :mari-voice-wrong-1
                                              {:offset                 28.882,
                                               :phrase-text            "That is"
                                               :phrase-text-translated "Es una",
                                               :start                  28.882,
                                               :type                   "animation-sequence",
                                               :duration               0.729,
                                               :volume                 0.2,
                                               :audio                  "/raw/audio/l2/a8/L2_A8_Mari.m4a",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 29.611, :anim "talk", :start 28.882}]},
                           :mari-voice-wrong-2
                                              {:offset                 31.579,
                                               :phrase-text            "starts with the sound",
                                               :phrase-text-translated "empieza con el sonido",
                                               :start                  31.579,
                                               :type                   "animation-sequence",
                                               :duration               1.922,
                                               :volume                 0.2,
                                               :audio                  "/raw/audio/l2/a8/L2_A8_Mari.m4a",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 33.501, :anim "talk", :start 31.579}]},
                           :mari-voice-wrong-3
                                              {:offset                 35.879,
                                               :phrase-text            "Touch the picture that makes this sound",
                                               :phrase-text-translated "Toca la foto que hace este sonido",
                                               :start                  35.879,
                                               :type                   "animation-sequence",
                                               :duration               2.461,
                                               :volume                 0.2,
                                               :audio                  "/raw/audio/l2/a8/L2_A8_Mari.m4a",
                                               :target                 "mari",
                                               :track                  1,
                                               :data                   [{:end 38.34, :anim "talk", :start 35.879}]},
                           :mary-says-task
                                              {:type     "test-var-scalar",
                                               :var-name "current-level",
                                               :value    "easy",
                                               :success  "current-concept-chant",
                                               :fail     "current-concept-sound-x3"},
                           :pick-box
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "set-concept-data", :type "action"}
                                                      {:fail        "pick-wrong",
                                                       :type        "test-var-scalar",
                                                       :success     "pick-correct",
                                                       :from-var    [{:var-name "current-concept", :action-property "value"}],
                                                       :from-params [{:param-property "target", :action-property "var-name"}]}]},
                           :pick-correct
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "mari-says-correct-answer", :type "action"}
                                                      {:fail     {:type "empty", :duration 100},
                                                       :type     "test-var-scalar",
                                                       :value    false,
                                                       :success  "count-correct-answer",
                                                       :var-name "last-pick-wrong"}
                                                      {:id "box-jump-in", :type "action"}
                                                      {:id "reset-and-repeat", :type "action"}]},
                           :pick-wrong
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "mari-says-wrong-answer", :type "action"}
                                                      {:id "count-wrong-answer", :type "action"}
                                                      {:id "set-boxes-skin", :type "action"}
                                                      {:type "set-variable", :var-name "last-pick-wrong", :var-value true}]},
                           :play
                                              {:type "sequence",
                                               :data ["renew-current-concept"
                                                      "check-level"
                                                      "mari-tap-hat"
                                                      "boxes-jump-out"
                                                      "set-concept-data"
                                                      "mary-says-task"]},
                           :renew-current-concept
                                              {:type "sequence-data",
                                               :data
                                                     [{:from        ["item-1" "item-2" "item-3" "item-4" "item-5" "item-6" "item-7" "item-8" "item-9" "item-10"],
                                                       :type        "vars-var-provider",
                                                       :on-end      "finish-activity",
                                                       :shuffled    true,
                                                       :variables   ["current-concept"],
                                                       :provider-id "current-concept"}
                                                      {:from      ["item-1" "item-2" "item-3" "item-4" "item-5" "item-6" "item-7" "item-8" "item-9" "item-10"],
                                                       :type      "vars-var-provider",
                                                       :unique    true,
                                                       :from-var
                                                                  [{:var-key         "concept-name",
                                                                    :var-name        "current-concept",
                                                                    :var-property    "concept-name",
                                                                    :action-property "exclude-property-values"}],
                                                       :shuffled  true,
                                                       :variables ["pair-concept-1" "pair-concept-2"]}
                                                      {:from      ["current-concept" "pair-concept-1" "pair-concept-2"],
                                                       :type      "vars-var-provider",
                                                       :shuffled  true,
                                                       :variables ["box1" "box2" "box3"]}]},
                           :renew-words
                                              {:type "sequence-data",
                                               :data
                                                     [{:from        "concepts-single",
                                                       :type        "lesson-var-provider",
                                                       :limit       1,
                                                       :repeat      3,
                                                       :variables   ["item-1" "item-2" "item-3"],
                                                       :provider-id "words-set"}
                                                      {:from        "concepts-all",
                                                       :type        "lesson-var-provider",
                                                       :shuffled    true,
                                                       :variables   ["item-4" "item-5" "item-6" "item-7" "item-8" "item-9" "item-10"],
                                                       :provider-id "words-set"}
                                                      {:from      ["item-1" "item-2" "item-3" "item-4" "item-5" "item-6" "item-7" "item-8" "item-9" "item-10"],
                                                       :type      "vars-var-provider",
                                                       :shuffled  true,
                                                       :variables ["item-1" "item-2" "item-3" "item-4" "item-5" "item-6" "item-7" "item-8" "item-9" "item-10"]}]},
                           :reset-and-repeat
                                              {:type "sequence-data",
                                               :data
                                                     [{:type "set-variable", :var-name "last-pick-wrong", :var-value false}
                                                      {:id "letters-hide", :type "action"}
                                                      {:id "boxes-disappear", :type "action"}
                                                      {:id "play", :type "action"}
                                                      ]},
                           :set-boxes-skin
                                              {:type "parallel",
                                               :data
                                                     [{:type       "set-slot",
                                                       :target     "box1",
                                                       :from-var   [{:var-name "box1", :var-property "image-src", :action-property "image"}],
                                                       :slot-name  "box1",
                                                       :attachment {:x 40, :scale-x 4, :scale-y 4}}
                                                      {:type       "set-slot",
                                                       :target     "box2",
                                                       :from-var   [{:var-name "box2", :var-property "image-src", :action-property "image"}],
                                                       :slot-name  "box1",
                                                       :attachment {:x 40, :scale-x 4, :scale-y 4}}
                                                      {:type       "set-slot",
                                                       :target     "box3",
                                                       :from-var   [{:var-name "box3", :var-property "image-src", :action-property "image"}],
                                                       :slot-name  "box1",
                                                       :attachment {:x 40, :scale-x 4, :scale-y 4}}]},
                           :set-boxes-skin-copy-2
                                              {:type "parallel",
                                               :data
                                                     [{:type       "set-slot",
                                                       :target     "box1",
                                                       :from-var   [{:var-name "box1", :var-property "image-src", :action-property "image"}],
                                                       :slot-name  "box1",
                                                       :attachment {:x 40, :scale-x 4, :scale-y 4}}
                                                      {:type       "set-slot",
                                                       :target     "box2",
                                                       :from-var   [{:var-name "box2", :var-property "image-src", :action-property "image"}],
                                                       :slot-name  "box1",
                                                       :attachment {:x 40, :scale-x 4, :scale-y 4}}
                                                      {:type       "set-slot",
                                                       :target     "box3",
                                                       :from-var   [{:var-name "box3", :var-property "image-src", :action-property "image"}],
                                                       :slot-name  "box1",
                                                       :attachment {:x 40, :scale-x 4, :scale-y 4}}]},
                           :set-concept-data
                                              {:type "sequence-data",
                                               :data
                                                     [{:id "set-letters-text", :type "action"}
                                                      {:fail     "set-boxes-skin-copy-2",
                                                       :type     "test-var-scalar",
                                                       :value    "hard",
                                                       :success  {:type "empty", :duration 100},
                                                       :var-name "current-level"}]},
                           :set-letters-text
                                              {:type "sequence-data",
                                               :data
                                                     [{:type      "set-attribute",
                                                       :target    "letter1",
                                                       :from-var  [{:var-name "box1", :var-property "letter", :action-property "attr-value"}],
                                                       :attr-name "text"}
                                                      {:type      "set-attribute",
                                                       :target    "letter2",
                                                       :from-var  [{:var-name "box2", :var-property "letter", :action-property "attr-value"}],
                                                       :attr-name "text"}
                                                      {:type      "set-attribute",
                                                       :target    "letter3",
                                                       :from-var  [{:var-name "box3", :var-property "letter", :action-property "attr-value"}],
                                                       :attr-name "text"}
                                                      {:id "letters-show", :type "action"}]},
                           :start-scene       {:type "sequence", :data ["start-activity" "renew-words" "init-vars" "intro" "play"]},
                           :start-activity    {:type "start-activity", :id "magic-hat"},
                           :stop-activity     {:type "stop-activity", :id "magic-hat"}},
           :triggers      {:stop {:on "back", :action "stop-activity"}, :start {:on "start", :action "start-scene"}},
           :metadata      {:prev "library", :autostart true}})
