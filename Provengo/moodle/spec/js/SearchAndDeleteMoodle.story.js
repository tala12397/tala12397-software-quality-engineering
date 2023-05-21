//@provengo summon selenium

story('Successful search in forum', function () {
  let s = new SeleniumSession().start('http://localhost')
  s.navigate_to_login()
  s.enter_details({ UserName: 'tal', Password:'Tala12397!'})
  s.navigate_to_coursePage({courseName:'qa'})
  s.navigate_to_forum()
  s.search_student({query:'abcd'})

})

story('Successful delete a message in forum by the teacher', function () {
  let s = new SeleniumSession().start('http://localhost')
  s.navigate_to_login()
  s.enter_details({ UserName: 'Admin', Password:'Roihass1*'})
  s.navigate_to_coursePage({courseName:'qa'})
  s.navigate_to_forum()
  s.search_admin({query:'abcd'})
  s.delete_message()

})
story('waiting for student to search', function () {
  block(Any("delete_message"), function () {
          waitFor(Any("search_student"))
  })

})




