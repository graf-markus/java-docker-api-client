package com.graf.docker.client.models;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graf.docker.client.models.Container.PortMapping;

public class ContainerTest {

	private static Container container;
	private static Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

	private static final String json = "{\n" + "      \"Id\": \"8dfafdbc3a40\",\n" + "      \"Names\": [\n"
			+ "        \"/boring_feynman\"\n" + "      ],\n" + "      \"Image\": \"ubuntu:latest\",\n"
			+ "      \"ImageID\": \"d74508fb6632491cea586a1fd7d748dfc5274cd6fdfedee309ecdcbc2bf5cb82\",\n"
			+ "      \"Command\": \"echo 1\",\n" + "      \"Created\": 1367854155,\n" + "      \"State\": \"Exited\",\n"
			+ "      \"Status\": \"Exit 0\",\n" + "      \"Ports\": [\n" + "        {\n"
			+ "          \"PrivatePort\": 2222,\n" + "          \"PublicPort\": 3333,\n"
			+ "          \"Type\": \"tcp\",\n" + "          \"IP\": \"10.0.0.1\"\n" + "        }\n" + "      ],\n"
			+ "      \"Labels\": {\n" + "        \"com.example.vendor\": \"Acme\",\n"
			+ "        \"com.example.license\": \"GPL\",\n" + "        \"com.example.version\": \"1.0\"\n"
			+ "      },\n" + "      \"SizeRw\": 12288,\n" + "      \"SizeRootFs\": 0,\n" + "      \"HostConfig\": {\n"
			+ "        \"NetworkMode\": \"default\"\n" + "      },\n" + "      \"NetworkSettings\": {\n"
			+ "        \"Networks\": {\n" + "          \"bridge\": {\n"
			+ "            \"NetworkID\": \"7ea29fc1412292a2d7bba362f9253545fecdfa8ce9a6e37dd10ba8bee7129812\",\n"
			+ "            \"EndpointID\": \"2cdc4edb1ded3631c81f57966563e5c8525b81121bb3706a9a9a3ae102711f3f\",\n"
			+ "            \"Gateway\": \"172.17.0.1\",\n" + "            \"IPAddress\": \"172.17.0.2\",\n"
			+ "            \"IPPrefixLen\": 16,\n" + "            \"IPv6Gateway\": \"\",\n"
			+ "            \"GlobalIPv6Address\": \"\",\n" + "            \"GlobalIPv6PrefixLen\": 0,\n"
			+ "            \"MacAddress\": \"02:42:ac:11:00:02\"\n" + "          }\n" + "        }\n" + "      },\n"
			+ "      \"Mounts\": [\n" + "        {\n" + "          \"Name\": \"fac362...80535\",\n"
			+ "          \"Source\": \"/data\",\n" + "          \"Destination\": \"/data\",\n"
			+ "          \"Driver\": \"local\",\n" + "          \"Mode\": \"ro,Z\",\n" + "          \"RW\": false,\n"
			+ "          \"Propagation\": \"\"\n" + "        }\n" + "      ]\n" + "    }";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		container = gson.fromJson(json, Container.class);
	}

	@Test
	public void testGetId() {
		assertEquals("8dfafdbc3a40", container.getId());
	}

	@Test
	public void testGetNames() {
		assertEquals("/boring_feynman", container.getNames()[0]);
	}

	@Test
	public void testGetImage() {
		assertEquals("ubuntu:latest", container.getImage());
	}

	@Test
	public void testGetImageId() {
		assertEquals("d74508fb6632491cea586a1fd7d748dfc5274cd6fdfedee309ecdcbc2bf5cb82", container.getImageId());
	}

	@Test
	public void testGetCommand() {
		assertEquals("echo 1", container.getCommand());
	}

	@Test
	public void testGetCreated() {
		assertEquals(1367854155, container.getCreated());
	}

	@Test
	public void testGetState() {
		assertEquals("Exited", container.getState());
	}

	@Test
	public void testGetStatus() {
		assertEquals("Exit 0", container.getStatus());
	}

	@Test
	public void testGetPorts() {
		PortMapping[] ports = container.getPorts();
		assertTrue(ports.length > 0);
		assertEquals(2222, ports[0].getPrivatePort());
		assertEquals(3333, ports[0].getPublicPort());
		assertEquals("tcp", ports[0].getType());
		assertEquals("10.0.0.1", ports[0].getIp());
	}

	@Test
	public void testGetLabels() {
		Map<String, String> labels = container.getLabels();
		assertTrue(labels.size() > 0);
		String[] keys = labels.keySet().toArray(new String[3]);
		String[] values = labels.values().toArray(new String[3]);
		assertEquals("com.example.vendor", keys[0]);
		assertEquals("com.example.license", keys[1]);
		assertEquals("com.example.version", keys[2]);

		assertEquals("Acme", values[0]);
		assertEquals("GPL", values[1]);
		assertEquals("1.0", values[2]);
	}

	@Test
	public void testGetSizeRw() {
		assertEquals(12288, container.getSizeRw());
	}

	@Test
	public void testGetSizeRootFs() {
		assertEquals(0, container.getSizeRootFs());
	}

	@Test
	public void testGetNetworkSettings() {
		NetworkSettings settings = container.getNetworkSettings();
		assertNotNull(settings);
	}

	@Test
	public void testGetMounts() {
		ContainerMount[] mounts = container.getMounts();
		assertNotNull(mounts);
		assertTrue(mounts.length > 0);
	}

	@Ignore
	@Test
	public void testToStringContainer() {
		String tempjson = json.replaceAll("\\s", "");
		String gsonJson = container.toString().replaceAll("\\s", "");
		assertEquals(tempjson, gsonJson);
	}

	@Ignore
	@Test
	public void testToStringPortMapping() {

	}
}
