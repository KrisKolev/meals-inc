
describe('Login page', ()=>{
  it('Logging in', ()=>{
    cy.visit('/')
      .get('#employeeUsername').clear().type("tpm1")
      .get('#employeePassword').clear().type("12345")
      .get('#loginButton').click();
    cy.hash().should('eq', '');
  });
})
