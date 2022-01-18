describe('Login page', ()=>{
  it('Logging out', ()=>{
    cy.visit('/')
      .get('#employeeUsername').clear().type("tpm1")
      .get('#employeePassword').clear().type("12345")
      .get('#loginButton').click();
    cy.wait(2000)
      .get("#logoutButton").click();
    cy.hash().should('eq', '');
  })
})
