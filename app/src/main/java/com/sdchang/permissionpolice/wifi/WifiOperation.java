package com.sdchang.permissionpolice.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.sdchang.permissionpolice.ProxyFunction;
import com.sdchang.permissionpolice.ProxyOperation;
import com.sdchang.permissionpolice.R;
import com.sdchang.permissionpolice.lib.request.RequestParams;
import com.sdchang.permissionpolice.lib.request.wifi.WifiManagerRequest;

import java.util.ArrayList;

/**
 *
 */
public class WifiOperation {
    static final ProxyOperation[] operations = new ProxyOperation[]{
            new ProxyOperation(WifiManagerRequest.ADD_NETWORK,
                    R.string.dialogTitle_wifiAddNetwork, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putInt(request.opCode(), mgr.addNetwork(request.wifiConfiguration0()));
                }
            }),
            new ProxyOperation(WifiManagerRequest.DISABLE_NETWORK,
                    R.string.dialogTitle_wifiDisableNetwork, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.disableNetwork(request.int0()));
                }
            }),
            new ProxyOperation(WifiManagerRequest.DISCONNECT,
                    R.string.dialogTitle_wifiDisconnect, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.disconnect());
                }
            }),
            new ProxyOperation(WifiManagerRequest.ENABLE_NETWORK,
                    R.string.dialogTitle_wifiEnableNetwork, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.enableNetwork(request.int0(), request.boolean0()));
                }
            }),
            new ProxyOperation(WifiManagerRequest.GET_CONFIGURED_NETWORKS,
                    R.string.dialogTitle_wifiGetConfiguredNetworks, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putParcelableArrayList(request.opCode(), new ArrayList<>(mgr.getConfiguredNetworks()));
                }
            }),
            new ProxyOperation(WifiManagerRequest.GET_CONNECTION_INFO,
                    R.string.dialogTitle_wifiGetConnectionInfo, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putParcelable(request.opCode(), mgr.getConnectionInfo());
                }
            }),
            new ProxyOperation(WifiManagerRequest.GET_DHCP_INFO,
                    R.string.dialogTitle_wifiGetDhcpInfo, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putParcelable(request.opCode(), mgr.getDhcpInfo());
                }
            }),
            new ProxyOperation(WifiManagerRequest.GET_SCAN_RESULTS,
                    R.string.dialogTitle_wifiGetScanResults, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putParcelableArrayList(request.opCode(), new ArrayList<>(mgr.getScanResults()));
                }
            }),
            new ProxyOperation(WifiManagerRequest.GET_WIFI_STATE,
                    R.string.dialogTitle_wifiGetWifiState, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putInt(request.opCode(), mgr.getWifiState());
                }
            }),
            new ProxyOperation(WifiManagerRequest.IS_WIFI_ENABLED,
                    R.string.dialogTitle_wifiIsWifiEnabled, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.isWifiEnabled());
                }
            }),
            new ProxyOperation(WifiManagerRequest.PING_SUPPLICANT,
                    R.string.dialogTitle_wifiPingSupplicant, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.pingSupplicant());
                }
            }),
            new ProxyOperation(WifiManagerRequest.REASSOCIATE,
                    R.string.dialogTitle_wifiReassociate, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.reassociate());
                }
            }),
            new ProxyOperation(WifiManagerRequest.RECONNECT,
                    R.string.dialogTitle_wifiReconnect, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.reconnect());
                }
            }),
            new ProxyOperation(WifiManagerRequest.REMOVE_NETWORK,
                    R.string.dialogTitle_wifiRemoveNetwork, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.removeNetwork(request.int0()));
                }
            }),
            new ProxyOperation(WifiManagerRequest.SAVE_CONFIGURATION,
                    R.string.dialogTitle_wifiSaveConfiguration, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.saveConfiguration());
                }
            }),
            new ProxyOperation(WifiManagerRequest.SET_WIFI_ENABLED,
                    0, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.setWifiEnabled(request.boolean0()));
                }
            }),
            new ProxyOperation(WifiManagerRequest.START_SCAN,
                    R.string.dialogTitle_wifiStartScan, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putBoolean(request.opCode(), mgr.startScan());
                }
            }),
            new ProxyOperation(WifiManagerRequest.UPDATE_NETWORK,
                    R.string.dialogTitle_wifiUpdateNetwork, 1, new ProxyFunction() {
                @Override
                public void execute(Context context, RequestParams request, Bundle response) {
                    WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    response.putInt(request.opCode(), mgr.updateNetwork(request.wifiConfiguration0()));
                }
            })
    };

    public static ProxyOperation getOperation(String opCode) {
        for (ProxyOperation operation : operations) {
            if (operation.mOpCode.equals(opCode)) {
                return operation;
            }
        }
        return null;
    }
}
