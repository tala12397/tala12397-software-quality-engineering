/* @Provengo summon selenium */

defineEvent(SeleniumSession, "navigate_to_login", function(session, e) {

    session.click("//*[@id='usernavigation']/div/div/span/a");
})
defineEvent(SeleniumSession, "enter_details", function(session, e) {
    session.writeText("//*[@id='username']", e.UserName);
    session.writeText("//*[@id='password']", e.Password);
    session.click("//*[@id='loginbtn']")
})
defineEvent(SeleniumSession, "navigate_to_coursePage", function(session, e) {
    session.click("/html/body/div[3]/nav/div[1]/nav/ul/li[3]/a")//click on my courses
    session.click("/html/body/div[3]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/a/div")//click on course name

})
defineEvent(SeleniumSession, "navigate_to_forum", function(session, e) {

    session.click("//*[@id='module-1']/div/div[1]/div/div[1]/div/div[2]/div[2]/a")

})
defineEvent(SeleniumSession, "search_student", function(session, e) {

    session.writeText("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[1]/div/div[1]/div/form/div/input",e.query)
    session.click("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[1]/div/div[1]/div/form/div/div/button")
})
defineEvent(SeleniumSession, "search_admin", function(session, e) {
    session.writeText("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[1]/div/div[1]/div/form/div/input",e.query)
    session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[1]/div/div[1]/div/form/div/div/button")
})


/**
 * The StartSearch event defines the selenium action for clicking the search button.
 */
defineEvent(SeleniumSession, "delete_message", function(session, e) {
    session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div/article/div/div/div/div[2]/div[2]/div/a[3]")//delete button
    session.click("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div/div/div[3]/div/div[1]/form/button")//continue button


})
