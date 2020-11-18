/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business;

import it.csi.csi.pfh.FHResult;
import it.csi.csi.pfh.FunctHandler;
import it.csi.csi.util.Param;
import it.csi.csi.wrapper.CSIException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;



public class TavtCache implements FunctHandler {
	
	static Map<SiceeorchCallKey, SiceeorchCallValue> cache = new HashMap<SiceeorchCallKey, SiceeorchCallValue>();

	static final long TTL = 8 * 60 * 60 * 1000; // TTL = 1h

	public FHResult doOnInvokeSynch(String methodName, Param[] params,
			FHResult prevres, Hashtable bag, boolean inPreChain)
			throws CSIException {
		if (mustCache(methodName)) {

			SiceeorchCallKey call = new SiceeorchCallKey(methodName, params);
			if (inPreChain) {
				SiceeorchCallValue cachedResult = cache.get(call);
				if (cachedResult != null) {
					// System.out.println("PDCache: found result for " + call);
					if ((System.currentTimeMillis() - cachedResult.birthTime) < TTL) {
						prevres.setResult(cachedResult.result);
						prevres.setSkipInvoke(true);
					} else
						cache.remove(call);
				}
				// else continue and call PA...
			}

			else { // post chain
				if (prevres.getException() == null) {
					// metti in cache il risultato
					// System.out.println("PDCache: caching result for " +
					// call);
					SiceeorchCallValue newVal = new SiceeorchCallValue(
							System.currentTimeMillis(), prevres.getResult());
					cache.put(call, newVal);
				}
			}
		}
		return prevres;
	}
	
	private boolean mustCache(String methodName) {
		if ("elencoComuni".equals(methodName)
				|| "elencoProvince".equals(methodName)
				|| "elencoRegioni".equals(methodName))
			return true;
		else
			return false;

	}
	
	class SiceeorchCallValue {
		public long birthTime;
		public Param result;

		public SiceeorchCallValue(long bt, Param p) {
			birthTime = bt;
			result = p;
		}
	}

	class SiceeorchCallKey {
		public String paramsKey;

		public SiceeorchCallKey(String methodName, Param[] params) {
			paramsKey += methodName;
			if (params != null && params.length > 0) {
				paramsKey += ":";
				String id = (String) (params[0].getValue());
				paramsKey += id;
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof SiceeorchCallKey) {
				SiceeorchCallKey other = (SiceeorchCallKey) obj;
				return paramsKey.equals(other.paramsKey);
			} else
				return false;
		}

		@Override
		public int hashCode() {

			return paramsKey.hashCode();
		}

		@Override
		public String toString() {
			return paramsKey;
		}

	}

}
