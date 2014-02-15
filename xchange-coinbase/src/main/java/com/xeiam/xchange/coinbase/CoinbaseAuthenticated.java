package com.xeiam.xchange.coinbase;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import si.mazi.rescu.ParamsDigest;

import com.xeiam.xchange.coinbase.dto.account.CoinbaseAccountChanges;
import com.xeiam.xchange.coinbase.dto.account.CoinbaseAddress;
import com.xeiam.xchange.coinbase.dto.account.CoinbaseAddressCallback;
import com.xeiam.xchange.coinbase.dto.account.CoinbaseAddresses;
import com.xeiam.xchange.coinbase.dto.account.CoinbaseContacts;
import com.xeiam.xchange.coinbase.dto.marketdata.CoinbaseAmount;
import com.xeiam.xchange.coinbase.dto.trade.CoinbaseTransactions;
import com.xeiam.xchange.coinbase.dto.trade.CoinbaseTransfers;

/**
 * @author jamespedwards42
 */
@Path("api/v1")
public interface CoinbaseAuthenticated {

  @GET
  @Path("account/balance")
  CoinbaseAmount getBalance(@HeaderParam("ACCESS_KEY") String apiKey, @HeaderParam("ACCESS_SIGNATURE") ParamsDigest signer, @HeaderParam("ACCESS_NONCE") long nonce) throws IOException;

  @GET
  @Path("account/receive_address")
  CoinbaseAddress getReceiveAddress(@HeaderParam("ACCESS_KEY") String apiKey, @HeaderParam("ACCESS_SIGNATURE") ParamsDigest signer, @HeaderParam("ACCESS_NONCE") long nonce) throws IOException;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("account/generate_receive_address")
  CoinbaseAddress generateReceiveAddress(CoinbaseAddressCallback callbackUrl, @HeaderParam("ACCESS_KEY") String apiKey, @HeaderParam("ACCESS_SIGNATURE") ParamsDigest signer,
      @HeaderParam("ACCESS_NONCE") long nonce) throws IOException;

  @GET
  @Path("account_changes")
  CoinbaseAccountChanges getAccountChanges(@QueryParam("page") Integer page, @HeaderParam("ACCESS_KEY") String apiKey, @HeaderParam("ACCESS_SIGNATURE") ParamsDigest signer,
      @HeaderParam("ACCESS_NONCE") long nonce) throws IOException;
  
  @GET
  @Path("addresses")
  CoinbaseAddresses getAddresses(@QueryParam("page") Integer page, @QueryParam("limit") Integer limit, @QueryParam("query") String query, @HeaderParam("ACCESS_KEY") String apiKey, @HeaderParam("ACCESS_SIGNATURE") ParamsDigest signer,
      @HeaderParam("ACCESS_NONCE") long nonce) throws IOException;

  @GET
  @Path("contacts") 
  CoinbaseContacts getContacts(@QueryParam("page") Integer page, @QueryParam("num_pages") Integer limit, @QueryParam("query") String query, @HeaderParam("ACCESS_KEY") String apiKey, @HeaderParam("ACCESS_SIGNATURE") ParamsDigest signer,
      @HeaderParam("ACCESS_NONCE") long nonce) throws IOException;
  
  
  
  @GET
  @Path("transfers") 
  CoinbaseTransfers getTransfers(@QueryParam("page") Integer page, @QueryParam("limit") Integer limit, @HeaderParam("ACCESS_KEY") String apiKey, @HeaderParam("ACCESS_SIGNATURE") ParamsDigest signer,
      @HeaderParam("ACCESS_NONCE") long nonce) throws IOException;

  @GET
  @Path("transactions") 
  CoinbaseTransactions getTransactions(@QueryParam("page") Integer page, @HeaderParam("ACCESS_KEY") String apiKey, @HeaderParam("ACCESS_SIGNATURE") ParamsDigest signer,
      @HeaderParam("ACCESS_NONCE") long nonce) throws IOException;

}
