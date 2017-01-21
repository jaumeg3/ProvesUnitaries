package kiosk;

import mocks.FalseValidationServiceMock;
import mocks.TrueValidationServiceMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import services.ValidationServiceImpl;

import static org.junit.Assert.*;

/**
 * Created by jaume on 21/01/17.
 *
 * Activate Emission Method Tests
 */
public class ActivateEmissionTest {

    @Test
    public void TestGoodActivateEmission() throws Exception {
        TrueValidationServiceMock TrueValidation = new TrueValidationServiceMock();
        VotingMachine votingMachine = new VotingMachine();
        ActivationCard activationCard = new ActivationCard("Any");

        votingMachine.setValidationService(TrueValidation);
        votingMachine.activateEmission(activationCard);
        assertTrue(votingMachine.canVote());
    }

    @Test(expected = IllegalStateException.class)
    public void TestActivateEmission2() throws Exception {
        FalseValidationServiceMock falseValidation = new FalseValidationServiceMock();
        VotingMachine votingMachine = new VotingMachine();
        ActivationCard activationCard = new ActivationCard("Any");

        votingMachine.setValidationService(falseValidation);
        votingMachine.activateEmission(activationCard);
    }

    @Test(expected = IllegalStateException.class)
    public void TestActivateEmission3() throws Exception {
        TrueValidationServiceMock TrueValidation = new TrueValidationServiceMock();
        VotingMachine votingMachine = new VotingMachine();
        ActivationCard activationCard = new ActivationCard("Any");

        votingMachine.setValidationService(TrueValidation);
        votingMachine.activateEmission(activationCard);
        votingMachine.activateEmission(activationCard);
    }

}