
describe('Employees page', ()=>{
  it('Creating Employee', ()=>{
    cy.visit('/')
      .get('#employeeUsername').clear().type("tpm1")
      .get('#employeePassword').clear().type("12345")
      .get('#loginButton').click()
      .get('#employeesButton').click();
    cy.wait(1000)
      .get('div[role=tab]').eq(1).click();
    cy.wait(1000)
      .get('#name').clear().type("FrontendTester")
      .get('#role').clear().type("Waiter")
      .get('#username').clear().type("fetester")
      .get('#password').clear().type("pass1")
      .get('#addEmpl').click();
    cy.hash().should('eq', '');
  });

  // it('Should delete FrontendTester', ()=>{
  //   cy.visit('/')
  //     .get('#employeeUsername').clear().type("tpm1")
  //     .get('#employeePassword').clear().type("12345")
  //     .get('#loginButton').click()
  //     .get('#employeesButton').click();
  //   cy.contains('td', 'FrontendTester').siblings().eq(0).children().eq(0).click();
  //   cy.hash().should('eq', '');
  // })
})
